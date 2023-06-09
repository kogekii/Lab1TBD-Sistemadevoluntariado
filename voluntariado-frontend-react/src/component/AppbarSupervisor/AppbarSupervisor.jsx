import { useLocation } from "react-router-dom";
import "./AppbarSupervisor.scss";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { useSession } from "../../services/Session/Session";

const pages = [
	{
		id: 'emergencias',
		label: 'Emergencias',
		href: '/s/dashboard/emergencias',
	}
]

function AppbarSupervisor() {
	const session = useSession();
	const location = useLocation();
	return (
		<Navbar expand="lg" sticky="top" className="appbar">
			<Container>
				<Navbar.Brand>Voluntariado</Navbar.Brand>
				<Navbar.Toggle aria-controls="basic-navbar-nav" />
				<Navbar.Collapse id="basic-navbar-nav">
					<Nav className="me-auto w-100">
						{pages.map(page => (
							<Nav.Link
								key={page.id}
								href={page.href}
								disabled={page.href === location.pathname}
							>
								{page.label}
							</Nav.Link>
						))}
						<NavDropdown title={session.decodedToken.nombre} id="basic-nav-dropdown" className="ms-auto">
							<NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
							<NavDropdown.Item href="#action/3.2">
								Another action
							</NavDropdown.Item>
							<NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
							<NavDropdown.Divider />
							<NavDropdown.Item onClick={() => session.logout()}>
								Cerrar Sesión
							</NavDropdown.Item>
						</NavDropdown>
					</Nav>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);
}

export default AppbarSupervisor;