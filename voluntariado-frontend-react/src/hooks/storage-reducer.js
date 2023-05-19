import { useEffect, useMemo, useReducer } from "react";

const channel = new BroadcastChannel('STORAGE::SESSION');
const CHANNEL_UPDATE_MESSAGE = 'UPDATED';

const _initReducer = (key, initReducer) => () => {
    const value = localStorage.getItem(key);
    let data = null;
    if(!!value) data = JSON.parse(value);
    if(typeof(initReducer) == 'function'){
        const newData = initReducer(data);
        if(newData !== data){
            localStorage.setItem(key, JSON.stringify(newData));
        }
        data = newData;
    }
    return data;
};

const _reducerHandler = (key, reducerHandler) => (state, action) => {
    if(action.__updateState === true){
        const value = localStorage.getItem(key);
        if(!!value){
            const newData = JSON.parse(value);
            return newData;
        }
        return state;
    }
    else{
        const newState = reducerHandler(state, action);
        const json = JSON.stringify(newState);
        localStorage.setItem(key, json);
        channel.postMessage(CHANNEL_UPDATE_MESSAGE);
        return newState;
    }
};

export function useStorageReducer(key, reducerHandler, initReducer){
    const handler1 = useMemo(() => _reducerHandler(key, reducerHandler), [key, reducerHandler]);
    const handler2 = useMemo(() => _initReducer(key, initReducer), [key, initReducer]);
    const [state, dispatch] = useReducer(handler1, null, handler2);

    useEffect(() => {
        const listener = (event) => {
            if(event.data === CHANNEL_UPDATE_MESSAGE){
                dispatch({ __updateState: true });
            }
        };
        channel.addEventListener('message', listener);
        return () => channel.removeEventListener('message', listener);
    }, [key]);

    return [state, dispatch];
};
