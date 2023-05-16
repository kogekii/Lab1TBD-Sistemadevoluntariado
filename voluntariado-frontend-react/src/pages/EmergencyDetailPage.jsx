import React, { useEffect } from 'react'
import Navbar from '../component/Navbar'
import EmergencyDetail from '../component/EmergencyDetail'
import { useParams } from 'react-router-dom'
export default function EmergencyDetailPage() {
    const {id} = useParams();
    useEffect(() => {
        console.log(id);
    }, [id])
  return (
    <div>
        <Navbar/>
        <h1 class='text-center'>Emergency {id}</h1>
        <EmergencyDetail id={id}/>
    </div>
  )
}
