import { Fragment } from "react";
import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";
import { Link } from "react-router-dom";

export default function EmergencyDetail({ emergencia, tareas }) {
    return (
        <Fragment>
            <Card className="mb-2">
                <Card.Header>{emergencia.nombre}</Card.Header>
                <Card.Body>
                    <Table size="sm">
                        <tbody>
                            <tr>
                                <td width="20%">
                                    <strong>Descripción:</strong>
                                </td>
                                <td>{emergencia.descrip}</td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <strong>Fecha Inicio:</strong>
                                </td>
                                <td>{emergencia.finicio}</td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <strong>Fecha Término:</strong>
                                </td>
                                <td>{emergencia.ffin}</td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <strong>Institución:</strong>
                                </td>
                                <td><Link>{emergencia.id_institucion}</Link></td>
                            </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
            <Card>
                <Table>
                    <thead>
                        <tr>
                            <th scope='col'>Nombre</th>
                            <th scope='col'>Descripción</th>
                            <th scope='col'>ID de Estado</th>
                            <th scope='col'>Inscritos</th>
                            <th scope='col'>Fecha de Inicio</th>
                            <th scope='col'>Fecha de Fin</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tareas.map((tarea) => (
                            <tr key={tarea.id}>
                                <td>{tarea.nombre}</td>
                                <td>{tarea.descrip}</td>
                                <td>{tarea.id_estado}</td>
                                <td>{tarea.catn_vol_inscritos}/{tarea.cant_vol_requeridos}</td>
                                <td>{tarea.finicio}</td>
                                <td>{tarea.ffin}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </Card>
        </Fragment>
    )
}
