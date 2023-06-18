import { Link } from "react-router-dom";
import Card from "react-bootstrap/esm/Card";
import Table from "react-bootstrap/esm/Table";

function TaskRank({ className, ranking }) {
    return (
        <Card className={className}>
            <Card.Header>Ranking Voluntarios</Card.Header>
            <Card.Body style={{ padding: 0 }}>
                <Table className="table-task-voluntarios-list">
                    <thead>
                        <tr>
                            <th scope="col" style={{ width: '15%', textAlign: 'center' }}>Puntaje</th>
                            <th scope="col">Voluntario</th>
                        </tr>
                    </thead>
                    <tbody>
                        {ranking.map((rank) => (
                            <tr key={rank.id}>
                                <td align="center">{rank.puntos}</td>
                                <td>
                                    <Link>Voluntario#{rank.id_voluntario}</Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </Card.Body>
        </Card>
    )
}

export default TaskRank;