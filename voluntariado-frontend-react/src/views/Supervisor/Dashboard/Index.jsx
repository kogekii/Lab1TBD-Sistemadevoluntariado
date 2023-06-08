import { Navigate, Route, Routes } from "react-router-dom";
import AppbarSupervisor from "../../../component/AppbarSupervisor/AppbarSupervisor";
import EmergenciasView from "./Emergencia/List";
import EmergenciaView from "./Emergencia/Show";

export default function VoluntarioDashboardIndexView(){
    return (
        <div className="dashboard-layout">
            <AppbarSupervisor />
            <Routes>
                <Route index path="" element={<Navigate to="emergencias" replace />} />
                <Route path="emergencias" element={<EmergenciasView />} />
                <Route path="emergencias/:id" element={<EmergenciaView />} />
            </Routes>
        </div>
    );
};
