import Vue from 'vue'
import VueRouter from 'vue-router'

import VoluntarioLoginView from '@/views/voluntario/Home/LoginView.vue';
import VoluntarioRegisterView from '@/views/voluntario/Home/RegisterView.vue';
import VoluntarioRecoveryView from '@/views/voluntario/Home/RecoveryView.vue';
import VoluntarioConfirmView from '@/views/voluntario/Home/ConfirmView.vue';
import VoluntarioDashboardView from '@/views/voluntario/Dashboard/Main.vue';
import VoluntarioDashPerfilView from '@/views/voluntario/Dashboard/Perfil.vue';
import VoluntarioDashTareasView from '@/views/voluntario/Dashboard/Tareas.vue';
import VoluntarioDashEmergenciasView from '@/views/voluntario/Dashboard/Emergencias.vue';

import SupervisorLoginView from '@/views/supervisor/Home/LoginView.vue';
import SupervisorRegisterView from '@/views/supervisor/Home/RegisterView.vue';
import SupervisorRecoveryView from '@/views/supervisor/Home/RecoveryView.vue';
import SupervisorConfirmView from '@/views/supervisor/Home/ConfirmView.vue';

Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	base: import.meta.env.BASE_URL,
	routes: [
		{
			path: '/',
			name: 'index',
			redirect: '/v'
		},
		// Rutas: Voluntario
		{
			path: '/v',
			name: 'voluntario-login',
			alias: '/v/login',
			component: VoluntarioLoginView
		},
		{
			path: '/v/register',
			name: 'voluntario-register',
			component: VoluntarioRegisterView
		},
		{
			path: '/v/recovery',
			name: 'voluntario-recovery',
			component: VoluntarioRecoveryView
		},
		{
			path: '/v/confirm',
			name: 'voluntario-confirm',
			component: VoluntarioConfirmView
		},
		{
			path: '/v/dashboard',
			name: 'voluntario-dashboard',
			component: VoluntarioDashboardView,
			children: [
				{
					path: '',
					redirect: '/v/dashboard/perfil',
				},
				{
					path: '/v/dashboard/perfil',
					name: 'v-dash-perfil',
					component: VoluntarioDashPerfilView
				},
				{
					path: '/v/dashboard/tasks',
					name: 'v-dash-tasks',
					component: VoluntarioDashTareasView
				},
				{
					path: '/v/dashboard/emergencies',
					name: 'v-dash-emergencies',
					component: VoluntarioDashEmergenciasView
				},
			],
		},
		// Rutas: Supervisor
		{
			path: '/s',
			name: 'supervisor-login',
			alias: '/s/login',
			component: SupervisorLoginView
		},
		{
			path: '/s/register',
			name: 'supervisor-register',
			component: SupervisorRegisterView
		},
		{
			path: '/s/recovery',
			name: 'supervisor-recovery',
			component: SupervisorRecoveryView
		},
		{
			path: '/s/confirm',
			name: 'supervisor-confirm',
			component: SupervisorConfirmView
		},
	]
})

export default router
