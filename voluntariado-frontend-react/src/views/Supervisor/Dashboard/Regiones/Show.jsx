import { useCallback, useEffect, useReducer } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import Container from 'react-bootstrap/esm/Container';
import { useSession } from '../../../../services/Session/Session';
import RegionesMenu from '../../../../component/Regiones/RegionesMenu';
import RegionesMapa from '../../../../component/Regiones/RegionesMapa';
import './Show.scss';
import EmergencyTasks from '../../../../component/Emergency/EmergencyTasks';

const regiones = [
	"Región de Arica y Parinacota",
	"Región de Tarapacá",
	"Región de Antofagasta",
	"Región de Atacama",
	"Región de Coquimbo",
	"Región de Valparaíso",
	"Región Metropolitana de Santiago",
	"Región del Libertador Bernardo O'Higgins",
	"Región del Maule",
	"Región del Bío-Bío",
	"Región de La Araucanía",
	"Región de Los Ríos",
	"Región de Los Lagos",
	"Región de Aysén del Gral.Ibañez del Campo",
	"Región de Magallanes y Antártica Chilena",
	"Zona sin demarcar",
];

function regionSort(r1, r2){
	console.log(r1);
	let i1 = regiones.indexOf(r1.nom_reg);
	if(i1 < 0) i1 = 100;
	let i2 = regiones.indexOf(r2.nom_reg);
	if(i2 < 0) i2 = 100;
	return i1 - i2;
}

const INIT_STATE = {
	loading: true,
	loadingTareas: true,
	error: null,
	regiones: [],
	currentRegion: null,
	tareas: [],
};

const actions = {
	'FETCH_LOADING': Symbol.for('FETCH_LOADING'),
	'FETCH_SUCCESS': Symbol.for('FETCH_SUCCESS'),
	'FETCH_ERROR': Symbol.for('FETCH_ERROR'),
	'CHANGE_REGION': Symbol.for('CHANGE_REGION'),
	'FETCH_LOADING_TAREAS': Symbol.for('FETCH_LOADING_TAREAS'),
	'FETCH_SUCCESS_TAREAS': Symbol.for('FETCH_SUCCESS_TAREAS'),
};

const reducerHandler = (state, action) => {
	if(action.type === actions.FETCH_LOADING){
		return { ...state, loading: true, error: null };
	}
	else if(action.type === actions.FETCH_SUCCESS){
		const regions = action.regiones;
		return {
			...state,
			loading: false,
			error: null,
			regiones: regions,
			currentRegion: (regions.length > 0) ? regions[0] : null,
		};
	}
	else  if(action.type === actions.CHANGE_REGION){
		return { ...state, currentRegion: action.region, tareas: [] };
	}
	else if(action.type === actions.FETCH_LOADING_TAREAS){
		return { ...state, loadingTareas: true, error: null };
	}
	else if(action.type === actions.FETCH_SUCCESS_TAREAS){
		return {
			...state,
			loadingTareas: false,
			error: null,
			tareas: action.tareas,
		};
	}
	else if(action.type === actions.FETCH_ERROR){
		return { ...state, loading: false, loadingGeometry: false, error: action.error };
	}
	return state;
};

export default function RegionesView() {
	const [state, dispatch] = useReducer(reducerHandler, INIT_STATE);
	const session = useSession();
	const { id } = useParams();

	useEffect(() => {
		dispatch({ type: actions.FETCH_LOADING });
		session.validate().then((sess) => axios.get('/api/region', {
			headers: { 'Authorization': 'Bearer '+sess.token },
		}))
		.then((res) => {
			dispatch({
				type: actions.FETCH_SUCCESS,
				regiones: res.data.sort(regionSort),
			});
		})
		.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
	}, [id, session]);

	useEffect(() => {
		if(!state.currentRegion) return;
		dispatch({ type: actions.FETCH_LOADING_TAREAS });
		session.validate().then((sess) => axios.get('/api/tarea/by-region/' + state.currentRegion.gid, {
			headers: { 'Authorization': 'Bearer '+sess.token },
		}))
		.then((res) => {
			dispatch({
				type: actions.FETCH_SUCCESS_TAREAS,
				tareas: res.data,
			});
		})
		.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
	}, [state.currentRegion, session]);
	
	const handleChangeRegion = useCallback((region) => dispatch({ type: actions.CHANGE_REGION, region }), []);

	return (
		<Container style={{ paddingBlock: '1rem' }}>
			{state.error ? (
				<div className="error">{state.error}</div>
			) : (
				<div className="regions-grid">
					<div className="grid-menu">
						<RegionesMenu
							regiones={state.regiones}
							region={state.currentRegion}
							loading={state.loading}
							onChange={handleChangeRegion}
						/>
					</div>
					<div className="grid-map">
						<RegionesMapa
							className="mb-2"
							region={state.currentRegion}
							tareas={state.tareas}
							loading={state.loading}
						/>
						<EmergencyTasks tareas={state.tareas} loading={state.loading || state.loadingTareas} />
					</div>
				</div>
			)}
		</Container>
	)
};
