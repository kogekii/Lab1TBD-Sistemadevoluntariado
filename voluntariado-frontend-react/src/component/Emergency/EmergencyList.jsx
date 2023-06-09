import { useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import './EmergencyList.scss';
import Card from 'react-bootstrap/Card';
import Table from 'react-bootstrap/Table';

export default function EmergencyList({ className, emergencias }) {
    const navigate = useNavigate();
    const handleRowClick = useCallback((emergencia) => navigate(emergencia.id.toString()), [navigate]);
    return (
        <Card className={className}>
            <Table responsive className="table-emergency-list">
                <thead>
                    <tr>
                        <th className="name">Nombre</th>
                        <th>Descripción</th>
                        <th className="date-start">Inicio</th>
                        <th className="location">Ubicación</th>
                    </tr>
                </thead>
                <tbody>
                    {emergencias.map((emergencia) => (
                        <tr key={emergencia.id} onClick={() => handleRowClick(emergencia)}>
                            <td>{emergencia.nombre}</td>
                            <td>{emergencia.descripcion}</td>
                            <td className="nowrap lower">{emergencia.fecha}</td>
                            <td className="nowrap lower">{emergencia.ubicacion}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Card>
    )
};
