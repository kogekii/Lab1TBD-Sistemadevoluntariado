import { useEffect, useState } from 'react';
import leaflet from 'leaflet';
import wktParse from 'wellknown';
import { MapContainer, TileLayer, Marker, Popup, Polygon, useMap } from 'react-leaflet';
import Card from "react-bootstrap/esm/Card";
import maker1 from '../../assets/marker1.png';
import maker2 from '../../assets/marker2.png';
import makerShadow from '../../assets/marker-shadow.png';
import './RegionesMapa.scss';

const DEFAULT_ZOOM = 7;

const blueMarkerIcon = leaflet.icon({
	iconUrl: maker1,
	shadowUrl: makerShadow,
	iconSize:     [25, 41],
	shadowSize:   [41, 41],
	iconAnchor:   [12, 41],
	shadowAnchor: [12, 41],
	popupAnchor:  [0, -43]
});

const redMarkerIcon = leaflet.icon({
	iconUrl: maker2,
	shadowUrl: makerShadow,
	iconSize:     [25, 41],
	shadowSize:   [41, 41],
	iconAnchor:   [12, 41],
	shadowAnchor: [12, 41],
	popupAnchor:  [0, -43]
});

function RecenterAutomatically({ center }){
	const map = useMap();
	useEffect(() => {
		map.setView(center, DEFAULT_ZOOM);
		map.panTo(center);
	}, [center, map]);
	return null;
};

export default function RegionesMapa({ className, region, tareas, loading=true }) {
	const [data, setData] = useState({ center: [0, 0], polygon: [] });

	useEffect(() => {
		if(!!region?.geom){
			const latlngs = wktParse(region.geom).coordinates;
			const poly = leaflet.polygon(latlngs);
			setData({
				center: poly.getBounds().getCenter(),
				polygon: latlngs,
			});
		}
	}, [region?.geom]);

	if(loading){
		return (<div className="loading">Cargando...</div>);
	}

	return (
		<Card className={className}>
			<Card.Header>Mapa de Tareas</Card.Header>
			<Card.Body style={{ padding: 0 }}>
				<MapContainer className="regions-map" center={data.center} zoom={DEFAULT_ZOOM} scrollWheelZoom={false}>
					<TileLayer
						attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
						url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
					/>
					<RecenterAutomatically center={data.center} />
					<Marker position={data.center} icon={blueMarkerIcon}>
						<Popup>{region.nom_reg}</Popup>
					</Marker>
					{tareas.map(tr => (
						<Marker key={tr.id} position={[tr.longitude, tr.latitude]} icon={redMarkerIcon}>
							<Popup>
								<strong>{tr.nombre}</strong>
								<div>{tr.descripcion}</div>
							</Popup>
						</Marker>
					))}
					<Polygon positions={data.polygon} />
				</MapContainer>
			</Card.Body>
		</Card>
	)
};
