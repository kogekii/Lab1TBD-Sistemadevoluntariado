import { Fragment, useEffect, useReducer } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import Container from 'react-bootstrap/esm/Container';
import { useSession } from '../../../../services/Session/Session';
import EmergencyDetail from '../../../../component/Emergency/EmergencyDetail';
import EmergencyTasks from '../../../../component/Emergency/EmergencyTasks';
import EmergencyRank from '../../../../component/Emergency/EmergencyRank';

const INIT_STATE = {
	loading: true,
	error: null,
	emergencia: null,
	tareas: [],
	ranking: [],
};

const actions = {
	'FETCH_LOADING': Symbol.for('FETCH_LOADING'),
	'FETCH_SUCCESS': Symbol.for('FETCH_SUCCESS'),
	'FETCH_ERROR': Symbol.for('FETCH_ERROR'),
};

const reducerHandler = (state, action) => {
	if(action.type === actions.FETCH_LOADING){
		return { ...state, loading: true, error: null };
	}
	else if(action.type === actions.FETCH_ERROR){
		return { ...state, loading: false, error: action.error };
	}
	else if(action.type === actions.FETCH_SUCCESS){
		return {
			...state,
			loading: false,
			error: null,
			emergencia: action.emergencia,
			tareas: action.tareas,
			ranking: action.ranking,
		};
	}
	return state;
};

export default function EmergenciaView() {
	const [state, dispatch] = useReducer(reducerHandler, INIT_STATE);
	const session = useSession();
	const { id } = useParams();

    useEffect(() => {
		dispatch({ type: actions.FETCH_LOADING });
		session.validate().then((sess) => {
			Promise.all([
				axios.get('/api/emergencia/' + id, {
					headers: { 'Authorization': 'Bearer '+sess.token },
				}),
				axios.get('/api/tarea/by-emergencia/' + id, {
					headers: { 'Authorization': 'Bearer '+sess.token },
				}),
				axios.get('/api/ranking/by-emergencia/' + id, {
					headers: { 'Authorization': 'Bearer '+sess.token },
				}),
			])
			.then(([res1, res2, res3]) => {
				dispatch({
					type: actions.FETCH_SUCCESS,
					emergencia: res1.data,
					tareas: res2.data,
					ranking: res3.data,
				});
			})
			.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
		})
		.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
    }, [id, session]);

	return (
		<Container style={{ paddingBlock: '1rem' }}>
			{state.loading ? (
				<div className="loading">Cargando...</div>
			):(state.error ? (
				<div className="error">{state.error}</div>
			):(
				<Fragment>
					<EmergencyDetail className="mb-2" emergencia={state.emergencia} />
					<EmergencyTasks className="mb-2" tareas={state.tareas} />
					<EmergencyRank ranking={state.ranking} tareas={state.tareas} />
				</Fragment>
			))}
		</Container>
	)
};
