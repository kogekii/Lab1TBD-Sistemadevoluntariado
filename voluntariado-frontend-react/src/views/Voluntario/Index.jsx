import { Route, Routes } from "react-router-dom";

import VoluntarioDashboardIndexView from "./Dashboard/Index";
import VoluntarioLoginView from "./Home/Login";

export default function VoluntarioIndexView(){
    return (
        <Routes>
            <Route path="login" element={<VoluntarioLoginView />} />
            <Route path="dashboard" element={<VoluntarioDashboardIndexView />} />
        </Routes>
    )
};
