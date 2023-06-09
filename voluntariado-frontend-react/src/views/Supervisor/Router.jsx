import { Route, Routes } from "react-router-dom";
import SupervisorLoginView from "./Home/Login";
import SupervisorDashboardIndexView from "./Dashboard/Index";
import AuthGuard from "../../component/AuthGuard";

export default function VoluntarioRouter(){
    return (
        <Routes>
            <Route path="login" element={
                <AuthGuard isAuthenticated={false} redirect="/s/dashboard">
                    <SupervisorLoginView />
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
