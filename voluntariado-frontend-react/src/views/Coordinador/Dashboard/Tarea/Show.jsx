import { Fragment, useCallback, useEffect, useReducer } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import Container from 'react-bootstrap/esm/Container';
import { useSession } from '../../../../services/Session/Session';
import TaskDetail from '../../../../component/Task/TaskDetail';
import TaskRank from '../../../../component/Task/TaskRank';
import TaskMap from '../../../../component/Task/TaskMap';

const INIT_STATE = {
	loading: true,
	error: null,
	tarea: null,
	ranking: [],
};

const actions = {
	'FETCH_LOADING': Symbol.for('FETCH_LOADING'),
	'FETCH_SUCCESS': Symbol.for('FETCH_SUCCESS'),
	'FETCH_ERROR': Symbol.for('FETCH_ERROR'),
	'CHANGE_TOTAL': Symbol.for('CHANGE_TOTAL'),
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
			tarea: action.tarea,
			ranking: action.ranking,
		};
	}
	return state;
};

export default function TareaView() {
	const [state, dispatch] = useReducer(reducerHandler, INIT_STATE);
	const session = useSession();
	const { id } = useParams();

    useEffect(() => {
		dispatch({ type: actions.FETCH_LOADING });
		session.validate().then((sess) => Promise.all([
			axios.get('/api/tarea/' + id, { headers: { 'Authorization': 'Bearer '+sess.token } }),
			axios.get('/api/ranking/by-tarea/' + id, { headers: { 'Authorization': 'Bearer '+sess.token } }),
		]))
		.then(([res1, res2]) => {
			dispatch({
				type: actions.FETCH_SUCCESS,
				tarea: res1.data,
				ranking: res2.data,
			});
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
					<TaskDetail className="mb-2" tarea={state.tarea} />
					<TaskMap className="mb-2" tarea={state.tarea} />
					<TaskRank ranking={state.ranking} />
				</Fragment>
			))}
		</Container>
	)
};
