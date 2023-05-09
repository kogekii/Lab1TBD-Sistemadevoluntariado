<template>
    <b-container class="my-3">
		<b-row>
			<b-col class="asignacion mb-4" col lg="5" md="12">
				<b-card title="Asignación">
					<b-card-text class="text-center p-3">
						<em>Sin asignación</em>
					</b-card-text>
				</b-card>
			</b-col>
			<b-col class="tareas" col lg="7" md="12">
				<h2>Tareas</h2>
				<b-card-group deck>
					<b-card title="Tarea 1">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 2">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 3">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 4">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 5">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 6">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 7">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 8">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 9">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
					<b-card title="Tarea 10">
						<b-card-text>Descripcion</b-card-text>
					</b-card>
				</b-card-group>
			</b-col>
		</b-row>
	</b-container>
</template>

<script>
export default {
    name: 'VoluntarioTareasView',
}
</script>

<style lang="scss" scoped>
.asignacion {
	position: relative;

	.card {
		position: sticky;
		top: 4.5rem;
	}
}

.tareas .card {
	&:not(:last-child){
		margin-bottom: 0.5rem;
	}

	h4{
		font-size: 1.2rem;
	}
}
</style>