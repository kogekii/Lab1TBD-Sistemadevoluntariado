import { useState } from 'react';
import { useFormik } from 'formik';
import axios, { AxiosError } from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Badge from 'react-bootstrap/Badge';
import Alert from 'react-bootstrap/Alert';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import useTitle from '../../../hooks/title';

const FORMIK_INIT_VALUES = {
	name: '',
	email: '',
	password: '',
	password2: '',
};

const REGEX_EMAIL = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
const formikValidator = values => {
	const errors = {};
	// email
	if (!values.email) {
		errors.email = 'Debes ingresar un correo';
	} else if (!REGEX_EMAIL.test(values.email)) {
		errors.email = 'Formato Inválido';
	}
	// password
	if (!values.password) {
		errors.password = 'Debes ingresar una contraseña';
	}
	if (!values.password2) {
		errors.password2 = 'Debes ingresar una contraseña';
	}
	else if (values.password2 !== values.password) {
		errors.password2 = 'Las contraseñas no coinciden';
	}
	return errors;
};

function SupervisorRegisterView(){
	useTitle('Supervisor - Registrar Usuario');
    const navigate = useNavigate();
	const [loading, setLoading] = useState(false);
	const formik = useFormik({
		initialValues: FORMIK_INIT_VALUES,
		validateOnBlur: true,
		validateOnChange: false,
		validate: formikValidator,
		onSubmit: (values, { setSubmitting, setFieldError }) => {
			setLoading(true);
			axios.post('/api/usuario/register', {
                name: values.name,
                email: values.email,
                password: values.password,
            }).catch(err => {
				if(err instanceof AxiosError){
					if(err.response.status === 401) setFieldError("backend", "Las credenciales son inválidas!");
					else setFieldError("backend", "No se pudo iniciar sesión!");
				}
				else setFieldError("backend", "Ocurrió un error inesperado!");
				setSubmitting(false);
			})
			.finally(() => navigate('/s/login'));
		},
	});

	return (
		<div className="abs-center p-3">
			<Card className="card-login">
				<Form noValidate onSubmit={formik.handleSubmit}>
					<Card.Body>
						<Card.Title>
                            Registrar Usuario <Badge>Supervisores</Badge>
                        </Card.Title>
						<Form.Group className="mb-2" controlId="formBasicName">
							<Form.Label>Nombre</Form.Label>
							<Form.Control
								type="text"
								placeholder="Nombre Apellido"
								name="name"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.name && !!formik.errors?.name}
								value={formik.values.name}
								disabled={loading}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.name}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicEmail">
							<Form.Label>Correo Electrónico</Form.Label>
							<Form.Control
								type="email"
								placeholder="Enter email"
								name="email"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.email && !!formik.errors?.email}
								value={formik.values.email}
								disabled={loading}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.email}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicPassword">
							<Form.Label>Contraseña</Form.Label>
							<Form.Control
								type="password"
								placeholder="Password"
								name="password"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.password && !!formik.errors?.password}
								value={formik.values.password}
								disabled={loading}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.password}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicPassword2">
							<Form.Label>Confirmar Contraseña</Form.Label>
							<Form.Control
								type="password"
								placeholder="Password"
								name="password2"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.password2 && !!formik.errors?.password2}
								value={formik.values.password2}
								disabled={loading}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.password2}</Form.Control.Feedback>
						</Form.Group>
						{(formik.errors?.backend) && (
							<Alert className="mt-2 mb-0" variant="danger">{formik.errors.backend}</Alert>
						)}
					</Card.Body>
					<Card.Footer className="card-action-footer">
						<Button variant="outline-primary" className="me-auto" as={Link} to="/s/login">
                            <FontAwesomeIcon icon={faArrowLeft} /> Volver
                        </Button>
						<Button variant="primary" type="submit" disabled={loading}>{loading ? 'Loading…' : 'Ingresar'}</Button>
					</Card.Footer>
				</Form>
			</Card>
		</div>
	);
};

export default SupervisorRegisterView;