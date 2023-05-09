<template>
	<div class="grid">
		<b-card title="Recuperar Contraseña" tag="article" class="m-3">
			<b-form @submit.prevent="onSubmit" @reset.prevent="onReset">
				<div class="my-2">
					<b-form-group id="input-group-email" label="Correo Electrónico:" label-for="input-email" class="my-2">
						<b-form-input
							id="input-email"
							v-model="form.email"
							type="email"
							placeholder="Ej: nombre.apellido@ejemplo.com"
							required
						/>
					</b-form-group>
                </div>
				<div class="card-actions mt-3">
					<b-button :to="{ name: 'supervisor-login' }" variant="outline-primary" class="me-1">Iniciar Sesión</b-button>
					<b-button type="submit" variant="primary">Enviar</b-button>
				</div>
			</b-form>
		</b-card>
	</div>
</template>

<script>
export default {
	name: 'SupervisorLoginView',
    data() {
		return {
			form: {
				email: '',
			}
		}
    },
    methods: {
		onSubmit() {
			alert(JSON.stringify(this.form));
		},
		onReset() {
			this.form.email = '';
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