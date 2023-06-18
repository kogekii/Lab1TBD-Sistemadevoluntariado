import { useCallback, useEffect, useReducer } from "react";
import axios from "axios";
import leaflet from 'leaflet';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import Form from 'react-bootstrap/Form';
import Card from "react-bootstrap/esm/Card";
import InputGroup from 'react-bootstrap/InputGroup';
import { useSession } from "../../services/Session/Session";
import './TaskMap.scss';
import maker1 from '../../assets/marker1.png';
import maker2 from '../../assets/marker2.png';
import makerShadow from '../../assets/marker-shadow.png';


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


const INIT_STATE = {
	voluntarios: [],
	limit: 10,
};

const actions = {
	CHANGE_VOLUNTARIOS: Symbol.for('CHANGE_VOLUNTARIOS'),
	CHANGE_LIMIT: Symbol.for('CHANGE_LIMIT'),
};

const reducerHandler = (state, action) => {
	if(action.type === actions.CHANGE_VOLUNTARIOS){
		return { ...state, voluntarios: action.voluntarios };
	}
	else if(action.type === actions.CHANGE_LIMIT){
		if(action.value !== state.limit && action.value > 0){
			return { ...state, limit: action.value };
		}
	}
	return state;
};

export default function TaskMap({ className, tarea, voluntarios, limit=10, onChangeLimit }) {
	const [state, dispatch] = useReducer(reducerHandler, INIT_STATE);
	const session = useSession();

    useEffect(() => {
		dispatch({ type: actions.FETCH_LOADING });
		session.validate().then((sess) => axios.get(`/api/tarea/${tarea.id}/voluntarios?limit=${state.limit}`, {
			headers: { 'Authorization': 'Bearer '+sess.token }
		}))
		.then((res) => dispatch({ type: actions.CHANGE_VOLUNTARIOS, voluntarios: res.data }))
		.catch(err => console.error(err));
    }, [tarea, state.limit, session]);

	const handleChangeLimit = useCallback((ev) => {
		let value = Number.parseInt(ev.target.value);
		if(!Number.isNaN(value) && value > 0){
			dispatch({ type: actions.CHANGE_LIMIT, value });
		}
	}, []);

	const coord = [tarea.latitude, tarea.longitude];

	return (
		<Card className={className}>
			<Card.Header className="task-map-card-header">
				<span className="me-2">Mapa Voluntarios</span>
				<InputGroup size="sm">
					<Form.Control type="number" value={state.limit} onChange={handleChangeLimit} />
				</InputGroup>
			</Card.Header>
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
					{state.voluntarios.map(vol => (
						<Marker key={vol.id} position={[vol.latitude, vol.longitude]} icon={blueMarkerIcon}>
							<Popup>
								<strong>{vol.nombre} {vol.apellido}</strong>
							</Popup>
						</Marker>
					))}
				</MapContainer>
			</Card.Body>
		</Card>
	)
};
