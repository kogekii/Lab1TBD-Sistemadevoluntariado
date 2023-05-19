import { Navigate, Route, Routes, BrowserRouter } from 'react-router-dom';
import './App.scss';

import SupervisorLoginView from './Supervisor/Home/Login';
import VoluntarioIndexView from './Voluntario/Index';
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
				<Route path="/v/*" element={<VoluntarioIndexView />} />
				<Route path="/s/*" element={<SupervisorLoginView />} />
			</Routes>
		</SessionProvider>
		</BrowserRouter>
	);
}

export default App;
