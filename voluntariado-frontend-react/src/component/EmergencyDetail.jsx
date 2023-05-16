import React, { useEffect, useState } from 'react'
import axios from 'axios'
export default function EmergencyDetail(props) {
    const [data, setData] = useState([]);
    useEffect(() => {
        axios.get(`http://localhost:8080/tarea/byemergencia/${props.id}`)
            .then((res) => {
                setData(res.data)
            })
    })
    return (
        <table class="table">
            <thead>
                <tr>
                    <th scope='col'>ID</th>
                    <th scope='col'>Nombre</th>
                    <th scope='col'>Descripción</th>
                    <th scope='col'>Cantidad de Voluntarios Requeridos</th>
                    <th scope='col'>ID de Emergencia</th>
                    <th scope='col'>Fecha de Inicio</th>
                    <th scope='col'>Fecha de Fin</th>
                    <th scope='col'>ID de Estado</th>
                    <th scope='col'>Cantidad de Voluntarios Inscritos</th>
                </tr>
            </thead>
            <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td scope='row'>{item.id}</td>
                        <td>{item.nombre}</td>
                        <td>{item.descrip}</td>
                        <td>{item.cant_vol_requeridos}</td>
                        <td>{item.id_emergencia}</td>
                        <td>{item.finicio}</td>
                        <td>{item.ffin}</td>
                        <td>{item.id_estado}</td>
                        <td>{item.catn_vol_inscritos}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}
