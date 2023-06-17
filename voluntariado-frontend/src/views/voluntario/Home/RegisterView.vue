<template>
	<div class="grid">
		<b-card title="Registrar" tag="article" class="m-3">
			<b-form @submit.prevent="onSubmit" @reset.prevent="onReset">
				<div class="my-2">
					<b-form-group id="input-group-firstname" label="Nombre:" label-for="input-firstname" class="my-2">
						<b-form-input
							id="input-firstname"
							v-model="form.firstname"
							placeholder="Ej: Juan"
							required
						/>
					</b-form-group>
					<b-form-group id="input-group-lastname" label="Apellido:" label-for="input-lastname" class="my-2">
						<b-form-input
							id="input-lastname"
							v-model="form.lastname"
							placeholder="Ej: Pérez"
							required
						/>
					</b-form-group>
					<b-form-group id="input-group-rut" label="RUT:" label-for="input-rut" class="my-2">
						<b-form-input
							id="input-rut"
							v-model="form.rut"
							placeholder="Ej: 12345678-9"
							required
						/>
					</b-form-group>
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
					<b-form-group id="input-group-password-confirm" label="Confirmar contraseña:" label-for="input-password-confirm" class="my-2">
						<b-form-input
							id="input-password-confirm"
							type="password"
							v-model="form.passwordConfirm"
							placeholder="Ej: palabra_1234"
							required
						/>
					</b-form-group>
				</div>
				<div class="card-actions mt-4">
					<b-button :to="{ name: 'voluntario-login' }" variant="outline-primary" class="me-1">Iniciar Sesión</b-button>
					<b-button type="submit" variant="primary">Registrar</b-button>
				</div>
			</b-form>
		</b-card>
	</div>
</template>

<script>
export default {
	name: 'VoluntarioRegisterView',
	data() {
		return {
			form: {
				firstname: '',
				lastname: '',
				rut: '',
				email: '',
				password: '',
				passwordConfirm: '',
			}
		}
	},
	methods: {
		onSubmit() {
			alert(JSON.stringify(this.form));
		},
		onReset() {
			this.form.firstname = '';
			this.form.lastname = '';
			this.form.rut = '';
			this.form.email = '';
			this.form.password = '';
			this.form.passwordConfirm = '';
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
  background: radial-gradient(red, blue);

	.card {
		min-width: 400px;
		max-width: 500px;
	}


}
</style>