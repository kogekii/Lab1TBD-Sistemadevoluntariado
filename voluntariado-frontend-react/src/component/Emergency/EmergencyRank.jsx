import { Link } from "react-router-dom";
import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";

function findTarea(tareas, id){
    return tareas.find(t => t.id === id)?.nombre || '-';
}

function EmergencyRank({ className, ranking, tareas }) {
    return (
        <Card className={className}>
            <Table className="table-emergency-voluntarios-list">
                <thead>
                    <tr>
                        <th scope="col" style={{ width: '15%', textAlign: 'center' }}>Puntaje</th>
                        <th scope="col" style={{ width: '25%' }}>Voluntario</th>
                        <th scope="col">Tarea</th>
                    </tr>
                </thead>
                <tbody>
                    {ranking.map((rank) => (
                        <tr key={rank.id}>
                            <td align="center">{rank.puntos}</td>
                            <td>
                                <Link>Voluntario#{rank.id_voluntario}</Link>
                            </td>
                            <td>
                                <Link to={'/s/dashboard/tareas/' + rank.id_tarea}>{findTarea(tareas, rank.id_tarea)}</Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Card>
    )
}

export default EmergencyRank;