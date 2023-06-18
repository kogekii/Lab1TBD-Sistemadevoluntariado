import { Navigate, Route, Routes, BrowserRouter } from 'react-router-dom';
import './App.scss';

import CoordinadorRouter from './Coordinador/Router';
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
				<Route index path="/" element={<Navigate to="/s/login" replace={true} />} />
				<Route path="/v/*" element={<VoluntarioRouter />} />
				<Route path="/s/*" element={<CoordinadorRouter />} />
			</Routes>
		</SessionProvider>
		</BrowserRouter>
	);
}

export default App;
