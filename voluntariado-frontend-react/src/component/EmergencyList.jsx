import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
export default function EmergencyList() {
    const [data, setData] = useState([])
    useEffect(() => {
        axios.get('http://localhost:8080/emergencia')
            .then((res) => {
                setData(res.data)
            })
    })
    return (
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">F-Inicio</th>
                    <th scope="col">F-Fin</th>
                    <th scope="col">Id-Institucion</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {data.map((eme) => (
                    <tr>
                        <th scope='row'>{eme.id}</th>
                        <th>{eme.nombre}</th>
                        <th>{eme.descrip}</th>
                        <th>{eme.finicio}</th>
                        <th>{eme.ffin}</th>
                        <th>{eme.id_institucion}</th>
                        <th><Link to={`/emergency/${eme.id}`}>GO</Link></th>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}
