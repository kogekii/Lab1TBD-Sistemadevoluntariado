import { Route, Routes } from "react-router-dom";
import AuthGuard from "../../component/AuthGuard";
import VoluntarioLoginView from "./Home/Login";
import VoluntarioDashboardIndexView from "./Dashboard/Index";
import VoluntarioRegisterView from "./Home/Register";

export default function VoluntarioRouter(){
	return (
		<Routes>
			<Route path="login" element={
				<AuthGuard isAuthenticated={false} redirect="/v/dashboard">
					<VoluntarioLoginView />
				</AuthGuard>
			} />
			<Route path="register" element={
				<AuthGuard isAuthenticated={false} redirect="/v/dashboard">
					<VoluntarioRegisterView />
				</AuthGuard>
			} />
			<Route path="dashboard/*" element={
				<AuthGuard isAuthenticated redirect="/v/login">
					<VoluntarioDashboardIndexView />
				</AuthGuard>
			} />
		</Routes>
	)
};
