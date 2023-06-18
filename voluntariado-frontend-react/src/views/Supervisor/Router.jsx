import { Route, Routes } from "react-router-dom";
import AuthGuard from "../../component/AuthGuard";
import SupervisorLoginView from "./Home/Login";
import SupervisorDashboardIndexView from "./Dashboard/Index";
import SupervisorRegisterView from "./Home/Register";

export default function VoluntarioRouter(){
    return (
        <Routes>
            <Route path="login" element={
                <AuthGuard isAuthenticated={false} redirect="/s/dashboard">
                    <SupervisorLoginView />
                </AuthGuard>
            } />
            <Route path="register" element={
                <AuthGuard isAuthenticated={false} redirect="/s/dashboard">
                    <SupervisorRegisterView />
                </AuthGuard>
            } />
            <Route path="dashboard/*" element={
                <AuthGuard isAuthenticated redirect="/s/login">
                    <SupervisorDashboardIndexView />
                </AuthGuard>
            } />
        </Routes>
    )
};
