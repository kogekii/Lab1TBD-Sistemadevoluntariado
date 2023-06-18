import { useCallback } from "react";
import { useNavigate } from "react-router-dom";
import "./EmergencyTasks.scss";
import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";

export default function EmergencyTasks({ className, tareas, loading=false }) {
    const navigate = useNavigate();
    const handleRowClick = useCallback((tarea) => navigate('/s/dashboard/tareas/' + tarea.id.toString()), [navigate]);
    return (
        <Card className={className}>
            <Card.Header>Tareas</Card.Header>
            <Card.Body style={{ padding: 0 }}>
                {(loading) ? (
                    <div className="p-4 text-center">Cargando...</div>
                ):((tareas.length === 0) ? (
                    <div className="p-4 text-center">No hay tareas...</div>
                ) : (
                    <Table className="table-emergency-tasks-list">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            {tareas.map((tarea) => (
                                <tr key={tarea.id} onClick={() => handleRowClick(tarea)}>
                                    <td>{tarea.nombre}</td>
                                    <td>{tarea.descripcion}</td>
                                    <td >{tarea.idEstadoTarea}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                ))}
            </Card.Body>
        </Card>
    )
}
