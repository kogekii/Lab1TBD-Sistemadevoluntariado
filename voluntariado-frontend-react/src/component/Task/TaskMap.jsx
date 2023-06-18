import Card from "react-bootstrap/esm/Card";
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import leaflet from 'leaflet';
import './TaskMap.scss';
// import maker1 from '../../assets/marker1.png';
import maker2 from '../../assets/marker2.png';
import makerShadow from '../../assets/marker-shadow.png';

// const blueMarkerIcon = leaflet.icon({
//     iconUrl: maker1,
//     shadowUrl: makerShadow,
//     iconSize:     [25, 41],
//     shadowSize:   [41, 41],
//     iconAnchor:   [12, 41],
//     shadowAnchor: [12, 41],
//     popupAnchor:  [0, -43]
// });

const redMarkerIcon = leaflet.icon({
    iconUrl: maker2,
    shadowUrl: makerShadow,
    iconSize:     [25, 41],
    shadowSize:   [41, 41],
    iconAnchor:   [12, 41],
    shadowAnchor: [12, 41],
    popupAnchor:  [0, -43]
});

export default function TaskMap({ className, tarea }) {
	const coord = [tarea.latitude, tarea.longitude];
	return (
		<Card className={className}>
			<Card.Header>Mapa Voluntarios</Card.Header>
			<Card.Body style={{ padding: 0 }}>
				<MapContainer className="task-map" center={coord} zoom={7} scrollWheelZoom={false}>
					<TileLayer
						attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
						url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
					/>
					<Marker position={coord} icon={redMarkerIcon}>
						<Popup>
							<strong>{tarea.nombre}</strong>
							<div>{tarea.descripcion}</div>
						</Popup>
					</Marker>
				</MapContainer>
			</Card.Body>
		</Card>
	)
};
