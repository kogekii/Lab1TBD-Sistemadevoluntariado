import { useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import './EmergencyList.scss';
import Card from 'react-bootstrap/Card';
import Table from 'react-bootstrap/Table';

export default function EmergencyList({ emergencias }) {
    const navigate = useNavigate();
    const handleRowClick = useCallback((emergencia) => navigate(emergencia.id.toString()), [navigate]);
    return (
        <Card>
            <Table responsive className="table-emergency-list">
                <thead>
                    <tr>
                        <th className="name">Nombre</th>
                        <th>Descripción</th>
                        <th className="date-start">Inicio</th>
                        <th className="date-end">Fin</th>
                        <th className="institution">Institución</th>
                    </tr>
                </thead>
                <tbody>
                    {emergencias.map((emergencia) => (
                        <tr key={emergencia.id} onClick={() => handleRowClick(emergencia)}>
                            <td>{emergencia.nombre}</td>
                            <td>{emergencia.descrip}</td>
                            <td className="nowrap lower">{emergencia.finicio}</td>
                            <td className="nowrap lower">{emergencia.ffin}</td>
                            <td className="nowrap lower">{emergencia.id_institucion}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Card>
    )
};
