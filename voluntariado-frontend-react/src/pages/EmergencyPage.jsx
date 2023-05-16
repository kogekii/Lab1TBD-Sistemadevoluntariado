import React from 'react'
import Navbar from '../component/Navbar'
import EmergencyList from '../component/EmergencyList'
export default function EmergencyPage() {
  return (
    
    <div>
        <Navbar/>
        <h1 class='text-center'>Emergency Pages</h1>
        <EmergencyList/>
    </div>
  )
}
