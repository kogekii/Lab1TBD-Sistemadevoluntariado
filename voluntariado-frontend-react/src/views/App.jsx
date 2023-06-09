import { Navigate, Route, Routes, BrowserRouter } from 'react-router-dom';
import './App.scss';

import SupervisorRouter from './Supervisor/Router';
import VoluntarioRouter from './Voluntario/Router';
import { SessionProvider } from '../services/Session/Session';
// import EmergencyPage from './pages/EmergencyPage';
// import EmergencyDetailPage from './pages/EmergencyDetailPage';
// import HomePages from './pages/HomePages';

function App() {
	return (
		<BrowserRouter>
		<SessionProvider>
			<Routes>
				<Route index path="/" element={<Navigate to="/v/login" replace={true} />} />
				<Route path="/v/*" element={<VoluntarioRouter />} />
				<Route path="/s/*" element={<SupervisorRouter />} />
			</Routes>
		</SessionProvider>
		</BrowserRouter>
	);
}

export default App;
