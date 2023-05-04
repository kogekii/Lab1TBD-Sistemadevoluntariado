// Router.js
import { createRouter, createWebHistory } from 'vue-router'
import HomePage from './pages/HomePage.vue'
import App from './App.vue'
import EmergencyPages from './pages/EmergencyPages.vue'
import EmergencyDetailPages from './pages/EmegencyDetailPage.vue'

const routes = [
    { path: '/', component: HomePage },
    { path: '/emergencias', component: EmergencyPages},
    { path: '/emergencias/:id', name: 'emergencia', component: EmergencyDetailPages}
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

