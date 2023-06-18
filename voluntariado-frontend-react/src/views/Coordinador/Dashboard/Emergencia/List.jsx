import React, { useEffect, useReducer } from 'react';
import axios from 'axios';
import Container from 'react-bootstrap/Container';
import { useSession } from '../../../../services/Session/Session';
import EmergencyList from '../../../../component/Emergency/EmergencyList';

const INIT_STATE = {
	loading: true,
	error: null,
	emergencias: [],
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
			emergencias: action.emergencias,
		};
	}
	return state;
};

export default function EmergenciasView() {
	const [state, dispatch] = useReducer(reducerHandler, INIT_STATE);
	const session = useSession();

    useEffect(() => {
		dispatch({ type: actions.FETCH_LOADING });
		session.validate().then((sess) => {
			axios.get('/api/emergencia', {
				headers: { 'Authorization': 'Bearer '+sess.token },
			})
			.then((res) => {
				dispatch({ type: actions.FETCH_SUCCESS, emergencias: res.data });
			})
			.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
		})
		.catch(err => dispatch({ type: actions.FETCH_ERROR, error: err.message }));
    }, [session]);

	return (
		<Container style={{ paddingBlock: '1rem' }}>
			<h2>Emergencias</h2>
			{state.loading ? (
				<div className="loading">Cargando...</div>
			):(state.error ? (
				<div className="error">{state.error}</div>
			):(
				<EmergencyList emergencias={state.emergencias} />
			))}
		</Container>
	)
};
