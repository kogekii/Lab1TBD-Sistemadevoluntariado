<template>
	<div class="grid">
		<b-card title="Confirmado" tag="article" class="m-3">
			<b-card-text>Su confirmó correctamente la cuenta de usuario asociada al correo electrónico "{{ email }}".</b-card-text>
			<div class="card-actions mt-3">
				<b-button :to="{ name: 'voluntario-login' }" variant="outline-primary" class="me-1">Iniciar Sesión</b-button>
			</div>
		</b-card>
	</div>
</template>

<script>
export default {
	name: 'VoluntarioConfirmView',
	data(){
		return {
			email: 'example@example.com'
		}
	}
}
</script>

<style lang="scss" scoped>
.grid {
	min-height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 4px;
	grid-auto-flow: column;

	.card {
		min-width: 400px;
		max-width: 500px;
	}
}
</style>