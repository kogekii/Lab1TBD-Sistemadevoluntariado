import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";
import { Link } from "react-router-dom";

export default function TaskDetail({ className, tarea }) {
    return (
        <Card className={className}>
            <Card.Header>{tarea.nombre}</Card.Header>
            <Card.Body>
                <Table size="sm">
                    <tbody>
                        <tr>
                            <td width="20%">
                                <strong>Descripción:</strong>
                            </td>
                            <td>{tarea.descripcion}</td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <strong>Emergencia:</strong>
                            </td>
                            <td>
                                <Link to={'/s/dashboard/emergencias/' + tarea.idEmergencia}>{tarea.idEmergencia}</Link>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <strong>Estado:</strong>
                            </td>
                            <td>{tarea.idEstadoTarea}</td>
                        </tr>
                    </tbody>
                </Table>
            </Card.Body>
        </Card>
    )
}
