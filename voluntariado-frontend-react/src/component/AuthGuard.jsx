import { Navigate } from "react-router-dom";
import { useSession } from "../services/Session/Session";

export default function AuthGuard({ children, redirect, isAuthenticated=true }) {
    const { isAuthenticated:authed } = useSession();
    if(isAuthenticated){
        if(authed) return children;
        else return (<Navigate to={redirect} replace />);
    }
    if(!isAuthenticated){
        if(!authed) return children;
        else return (<Navigate to={redirect} replace />);
    }
    return (<div>Error: Wrong config!</div>);
};