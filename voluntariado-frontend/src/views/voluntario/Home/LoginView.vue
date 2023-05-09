<template>
	<div class="grid">
		<b-card title="Iniciar Sesión" tag="article" class="m-3">
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
					<b-form-group id="input-group-password" label="Contraseña:" label-for="input-password" class="my-2">
						<b-form-input
							id="input-password"
							type="password"
							v-model="form.password"
							placeholder="Ej: palabra_1234"
							required
						/>
					</b-form-group>
					<b-form-group id="input-group-remember">
						<b-form-checkbox
							id="input-remember"
							name="input-remember"
							v-model="form.remember"
						>
							<span class="ms-1">Mantener Sesión</span>
						</b-form-checkbox>
					</b-form-group>
				</div>
				<div class="my-2">
					<b-link :to="{ name: 'voluntario-recovery' }">Recuperar Contraseña</b-link> | 
					<b-link :to="{ name: 'supervisor-login' }">Supervisor</b-link>
				</div>
				<div class="card-actions">
					<b-button :to="{ name: 'voluntario-register' }" variant="outline-primary" class="me-1">Registrar</b-button>
					<b-button type="submit" variant="primary">Iniciar Sesión</b-button>
				</div>
			</b-form>
		</b-card>
	</div>
</template>

<script>
export default {
	name: 'VoluntarioLoginView',
    data() {
		return {
			form: {
				email: '',
				password: '',
				remember: false,
			}
		}
    },
    methods: {
		onSubmit() {
			alert(JSON.stringify(this.form));
		},
		onReset() {
			this.form.email = '';
			this.form.password = '';
			this.form.remember = false;
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