import { Navigate, Route, Routes } from "react-router-dom";
import EmergencyView from "./EmergencyView";
import EmergencyDetailView from "./EmergencyDetailView";
import Appbar from "../../../component/Appbar/Appbar";

export default function VoluntarioDashboardIndexView(){
    return (
        <div className="dashboard-layout">
            <Appbar />
            <Routes>
                <Route index path="" element={<Navigate to="emergency" />} />
                <Route path="emergency" element={<EmergencyView />} />
                <Route path="emergency/:id" element={<EmergencyDetailView />} />
            </Routes>
        </div>
    );
};
