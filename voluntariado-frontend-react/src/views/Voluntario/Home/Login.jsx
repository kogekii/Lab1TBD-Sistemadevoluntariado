import { useFormik } from 'formik';
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Badge from 'react-bootstrap/Badge';
import Alert from 'react-bootstrap/Alert';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { useSession } from '../../../services/Session/Session';
import useTitle from '../../../hooks/title';

const FORMIK_INIT_VALUES = {
	email: '',
	password: '',
	remember: false,
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
	return errors;
};

export default function VoluntarioLoginView(){
	useTitle('Voluntario - Iniciar Sesión');
	const session = useSession();
	const formik = useFormik({
		initialValues: FORMIK_INIT_VALUES,
		validateOnBlur: true,
		validateOnChange: false,
		validate: formikValidator,
		onSubmit: (values, { setSubmitting, setFieldError }) => {
			session.login(values.email, values.password).catch(err => {
				setFieldError("authentication", "No se pudo iniciar sesion!");
				setSubmitting(false);
			})
		},
	});

	return (
		<div className="abs-center p-3">
			<Card className="card-login">
				<Form noValidate onSubmit={formik.handleSubmit}>
					<Card.Body>
						<Card.Title>
							Iniciar Sesión <Badge>Voluntarios</Badge>
						</Card.Title>
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
							/>
							<Form.Control.Feedback type="invalid">{formik.errors?.password}</Form.Control.Feedback>
						</Form.Group>
						<Form.Group className="mb-2" controlId="formBasicCheckbox">
							<Form.Check
								type="checkbox"
								label="Recuérdame"
								name="remember"
								onChange={formik.handleChange}
								isInvalid={formik.touched.remember && !!formik.errors?.remember}
								checked={formik.values.remember}
							/>
						</Form.Group>
						<Button variant="link" as={Link} to="/v/account-recover">Olvidé mi contraseña</Button>
						{(formik.errors?.authentication) && (
							<Alert className="mt-2 mb-0" variant="danger">{formik.errors.authentication}</Alert>
						)}
					</Card.Body>
					<Card.Footer className="card-action-footer">
						<Button variant="outline-primary" className="me-auto" as={Link} to="/s/login">
							<FontAwesomeIcon icon={faUser} /> Supervisores
						</Button>
						<Button variant="outline-primary" as={Link} to="/v/register">Ir a Registrar</Button>
						<Button variant="primary" type="submit">Ingresar</Button>
					</Card.Footer>
				</Form>
			</Card>
		</div>
	);
};
