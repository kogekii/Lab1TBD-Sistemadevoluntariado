import { Route, Routes } from "react-router-dom";
import AuthGuard from "../../component/AuthGuard";
import CoordinadorLoginView from "./Home/Login";
import CoordinadorDashboardIndexView from "./Dashboard/Index";
import CoordinadorRegisterView from "./Home/Register";

export default function VoluntarioRouter(){
    return (
        <Routes>
            <Route path="login" element={
                <AuthGuard isAuthenticated={false} redirect="/s/dashboard">
                    <CoordinadorLoginView />
                </AuthGuard>
            } />
            <Route path="register" element={
                <AuthGuard isAuthenticated={false} redirect="/s/dashboard">
                    <CoordinadorRegisterView />
                </AuthGuard>
            } />
            <Route path="dashboard/*" element={
                <AuthGuard isAuthenticated redirect="/s/login">
                    <CoordinadorDashboardIndexView />
                </AuthGuard>
            } />
        </Routes>
    )
};
