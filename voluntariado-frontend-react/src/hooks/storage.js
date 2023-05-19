// import { useCallback, useEffect, useReducer } from "react";

// const initReducer = (key) => {
//     const value = localStorage.getItem(key);
//     if(!!value){
//         const data = JSON.parse(value);
//         return data;
//     }
//     return null;
// };

// const reducerHandler = (_, data) => data;

// export function useStorage(key){
//     const [state, dispatch] = useReducer(reducerHandler, null, initReducer);
//     useEffect(() => {
//         const value = localStorage.getItem(key);
//         if(!!value){
//             const data = JSON.parse(value);
//             dispatch(data);
//         }
//     }, [key, dispatch]);

//     const update = useCallback((value) => {
//         if(value == null) localStorage.removeItem(key);
//         else{
//             const json = JSON.stringify(value);
//             localStorage.setItem(key, json);
//         }
//         dispatch(value);
//     }, [key, dispatch]);

//     return [state, update];
// };
