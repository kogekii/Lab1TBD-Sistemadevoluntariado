import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";

export default function EmergencyDetail({ className, emergencia }) {
    return (
        <Card className={className}>
            <Card.Header>{emergencia.nombre}</Card.Header>
            <Card.Body>
                <Table size="sm">
                    <tbody>
                        <tr>
                            <td width="20%">
                                <strong>Descripción:</strong>
                            </td>
                            <td>{emergencia.descripcion}</td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <strong>Fecha Inicio:</strong>
                            </td>
                            <td>{emergencia.fecha}</td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <strong>Ubicación:</strong>
                            </td>
                            <td>{emergencia.ubicacion}</td>
                        </tr>
                    </tbody>
                </Table>
            </Card.Body>
        </Card>
    )
}
