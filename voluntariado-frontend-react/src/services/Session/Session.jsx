import { createContext, useCallback, useContext } from "react";
import { isExpired, decodeToken } from "react-jwt";
import axios from "axios";
import config from "../../config";
import { useStorageReducer } from "../../hooks/storage-reducer";

class SessionError extends Error {
    constructor(code, ...args){
        super(...args);
        this.code = code;
    };
};

SessionError.NOT_AUTHENTICATED = Symbol.for('NOT_AUTHENTICATED');

export const SessionContext = createContext({
    isAuthenticated: false,
    isExpired: false,
    token: null,
    refreshToken: null,
    storage: {},
});
export const useSession = () => useContext(SessionContext);

const initReducer = (initValue) => {
    if(initValue) return initValue;
    return {
        isAuthenticated: false,
        isExpired: false,
        token: null,
        refreshToken: null,
        storage: {},
    };
}

const actions = {
    RESET_SESSION: Symbol.for('RESET_SESSION'),
    INIT_SESSION: Symbol.for('INIT_SESSION'),
    SET_ITEM: Symbol.for('SET_ITEM'),
    UNSET_ITEM: Symbol.for('UNSET_ITEM'),
};

const reducerHandler = (state, action) => {
    if(action.type === actions.RESET_SESSION){
        return {
            isAuthenticated: false,
            isExpired: false,
            token: null,
            refreshToken: null,
            storage: {},
        };
    }
    else if(action.type === actions.INIT_SESSION){
        const token = action.token;
        const expired = isExpired(token);
        const decoded = decodeToken(token);
        return {
            token,
            refreshToken: action.refreshToken,
            isAuthenticated: true,
            isExpired: expired,
            decodedToken: decoded,
            storage: {},
        };
    }
    else if(action.type === actions.SET_ITEM){
        return {
            ...state,
            storage: {
                ...state.storage,
                [action.key]: action.value,
            }
        }
    }
    else if(action.type === actions.UNSET_ITEM){
        const key = action.key;
        const storage = { ...state.storage };
        if(key in storage) delete storage[key];
        return { ...state, storage };
    }
    return state;
};

export function SessionProvider({ children }){
    const [state, dispatch] = useStorageReducer(config.STORAGE_SESSION_KEY, reducerHandler, initReducer);

    const login = useCallback(async (email, password, remember=false) => {
        const res = await axios.post('/api/login', { email, password });
        const token = res.headers.authorization;
        dispatch({ type: actions.INIT_SESSION, token });
    }, [dispatch]);

    const logout = useCallback(() => dispatch({ type: actions.RESET_SESSION }), [dispatch]);
    const setItem = useCallback((key, value) => dispatch({ type: actions.SET_ITEM, key, value }), [dispatch]);
    const unsetItem = useCallback((key) => dispatch({ type: actions.UNSET_ITEM, key }), [dispatch]);

    const validate = async () => {
        if(!state.isAuthenticated){
            throw new SessionError(SessionError.NOT_AUTHENTICATED, 'No hay ningúna sesión de usuario iniciada!');
        }
        if(state.isExpired){
            console.log(state.refreshToken);
            // ask for another token with verificationTOken
            return { ...state };
        }
        return state;
    };

    return (
        <SessionContext.Provider value={{ ...state, login, logout, setItem, unsetItem, validate }}>
            {children}
        </SessionContext.Provider>
    );
};