import { Route, Routes } from "react-router-dom";

import SupervisorDashboardIndexView from "./Dashboard/Index";
import SupervisorLoginView from "./Home/Login";

export default function SupervisorIndexView(){
    return (
        <Routes>
            <Route path="login" element={<SupervisorLoginView />} />
            <Route path="dashboard" element={<SupervisorDashboardIndexView />} />
        </Routes>
    )
};
