import { useEffect } from "react";

export default function useTitle(title){
    useEffect(() => {
        const prevTitle = document.title;
        if(typeof(title) === 'function'){
            document.title = title(prevTitle);
        }
        else{
            document.title = title;
        }
        return () => {
            document.title = prevTitle;
        }
    }, [title]);
};
