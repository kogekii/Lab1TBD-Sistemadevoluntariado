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
  background: -webkit-linear-gradient(90deg, #278666 10%, #fccb6e 90%);
  background:    -moz-linear-gradient(90deg, #65997d 10%, #fccb6e 90%);
  background:     -ms-linear-gradient(90deg, #65997d 10%, #fccb6e 90%);
  background:      -o-linear-gradient(90deg, #28a863 10%, #fccb6e 90%);
  background:         linear-gradient(90deg, #65997d 10%, #fccb6e 90%);


	.card {
		min-width: 400px;
		max-width: 500px;
    border: black 2px solid;

 }
  .card-title {
    text-align:center;
    color: #fff;
    font-family: 'Oswald', sans-serif;
    font-size: 28px;
    letter-spacing: 0;
    text-shadow: -3px -3px 3px #d7c236, 3px -3px 3px rgba(17, 217, 17, 0.48), -3px 3px 3px #d9bc11, 3px 3px 3px rgba(67, 173, 116, 0.63);
  }
  .form-control {
    border: 1.5px solid #020000;
  }
}
</style>