import { useFormik } from 'formik';
import axios from 'axios';
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
	nombre: '',
	apellido: '',
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

function VoluntarioRegisterView(){
	useTitle('Voluntario - Registrar Usuario');
	const navigate = useNavigate();
	const formik = useFormik({
		initialValues: FORMIK_INIT_VALUES,
		validateOnBlur: true,
		validateOnChange: false,
		validate: formikValidator,
		onSubmit: (values, { setSubmitting, setFieldError }) => {
			axios.post('/api/voluntario/register', {
				nombre: values.nombre,
				apellido: values.apellido,
				email: values.email,
				password: values.password,
			})
			.then((res) => {
				setSubmitting(false);
				if(res?.data?.error){
					setFieldError("backend", (res.data.message) ? res.data.message : res.data.error);
				}
				else navigate('/v/login');
			})
			.catch(err => {
				setSubmitting(false);
				setFieldError("backend", err.message);
				console.error(err);
			})
		},
	});

	return (
		<div className="abs-center p-3">
			<Card className="card-login">
				<Form noValidate onSubmit={formik.handleSubmit}>
					<Card.Body>
						<Card.Title>
							Registrar Usuario <Badge>Voluntarioes</Badge>
						</Card.Title>
						<Form.Group className="mb-2" controlId="formBasicNombre">
							<Form.Label>Nombre</Form.Label>
							<Form.Control
								type="text"
								placeholder="Ej: John"
								name="nombre"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.nombre && !!formik.errors?.nombre}
								value={formik.values.nombre}
								disabled={formik.isSubmitting}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.nombre}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicApellido">
							<Form.Label>Apellido</Form.Label>
							<Form.Control
								type="text"
								placeholder="Ej: Wick"
								name="apellido"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.apellido && !!formik.errors?.apellido}
								value={formik.values.apellido}
								disabled={formik.isSubmitting}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.apellido}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicEmail">
							<Form.Label>Correo Electrónico</Form.Label>
							<Form.Control
								type="email"
								placeholder="user.name@example.com"
								name="email"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.email && !!formik.errors?.email}
								value={formik.values.email}
								disabled={formik.isSubmitting}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.email}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicPassword">
							<Form.Label>Contraseña</Form.Label>
							<Form.Control
								type="password"
								placeholder="Ingresar contraseña"
								name="password"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.password && !!formik.errors?.password}
								value={formik.values.password}
								disabled={formik.isSubmitting}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.password}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicPassword2">
							<Form.Label>Confirmar Contraseña</Form.Label>
							<Form.Control
								type="password"
								placeholder="Confirmar contraseña"
								name="password2"
								onChange={formik.handleChange}
								onBlur={formik.handleBlur}
								isInvalid={formik.touched.password2 && !!formik.errors?.password2}
								value={formik.values.password2}
								disabled={formik.isSubmitting}
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.password2}</Form.Control.Feedback>
						</Form.Group>
						{(formik.errors?.backend) && (
							<Alert className="mt-2 mb-0" variant="danger">{formik.errors.backend}</Alert>
						)}
					</Card.Body>
					<Card.Footer className="card-action-footer">
						<Button variant="outline-primary" className="me-auto" as={Link} to="/v/login">
							<FontAwesomeIcon icon={faArrowLeft} /> Volver
						</Button>
						<Button variant="primary" type="submit" disabled={formik.isSubmitting}>{formik.isSubmitting ? 'Loading…' : 'Registrar'}</Button>
					</Card.Footer>
				</Form>
			</Card>
		</div>
	);
};

export default VoluntarioRegisterView;