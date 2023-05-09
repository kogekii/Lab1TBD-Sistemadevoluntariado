<template>
	<b-navbar toggleable="lg" type="dark" variant="dark" class="appbar">
		<b-navbar-brand href="#" class="px-2">Voluntariado</b-navbar-brand>
		<b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
		<b-collapse id="nav-collapse" is-nav>
			<b-navbar-nav>
				<b-nav-item :to="{ name: 'v-dash-tasks' }">Tareas</b-nav-item>
				<b-nav-item :to="{ name: 'v-dash-emergencies' }">Emergencias</b-nav-item>
				<b-nav-item :to="{ name: 'v-dash-perfil' }">Perfil</b-nav-item>
			</b-navbar-nav>
		</b-collapse>
	</b-navbar>
</template>

<script>
export default {
	name: 'Appbar',
}
</script>

<style lang="scss" scoped>
.appbar{
	position: sticky;
	top: 0;
	z-index: 10;
	justify-content: flex-start;
}
</style>