<template>
<v-card class="ma-8 pa-8" hover width="40%">
    <v-card-title>
        Please give us feedback
    </v-card-title>
    <v-form
    ref="form"
    @submit.prevent="submit"
    >
        <v-alert v-show="error === true" type="info" dismissible>
            Please make sure all fields are filled.
        </v-alert>
        <v-col>
            <v-row>
                <v-text-field
                placeholder='Name'
                v-model="name"
                :rules="requiredRule"
                >
                </v-text-field>
            </v-row>
            <v-row>
                <v-text-field
                placeholder='Email address'
                v-model="email"
                :rules="emailRules"
                >
                </v-text-field>
            </v-row>
            <v-row>
                <v-textarea
                auto-grow
                placeholder='Text'
                 v-model="text"
                :rules="requiredRule"
                >
                </v-textarea>
            </v-row>
            <v-row>
                <v-select
                :items="items"
                label="Category"
                v-model="category"
                multiple
                :rules="requiredRule">
                </v-select>
            </v-row>
            <v-card-actions>
                <v-btn
                block
                color="success"
                class="mt-2"
                @click="submit"
                type="submit"
                >Send</v-btn>
            </v-card-actions>
        </v-col>
    </v-form>
</v-card>
</template>

<script>

    export default {
        data() {
            return {
                items: [
                    {text: "-Application-", disabled: true},
                    {text: "--Health--", disabled: true},
                    {text: "Patients portal"},
                    {text: "Doctors portal"},
                    {text: "--Remote visits portal--", disabled: true},
                    {text: "Registration"},
                    {text: "Virtual visit"},
                    {text: "--Document management--", disabled: true},
                    {text: "Open KM"},
                    {text: "Microsoft SharePoint"},
                ],
                 emailRules: [
                    v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                ],
                requiredRule: [
                    v => !!v || 'Item is required',
                ],
                name: "",
                email: "",
                text: "",
                category: [],
                error: false
            }
        },
        methods: {
            submit() {
                if (this.validateBeforeSubmit()) {
                    const payload = {
                        "name": this.name,
                        "email": this.email,
                        "text": this.text,
                        "category": this.category
                    }
                    console.log('data:::', payload)
                    this.$emit('postFeedback', payload)
                }
                this.reset()
            },
             reset () {
                this.$refs.form.reset()
            },
            validateBeforeSubmit() {
                if (this.name && this.email && this.text && this.category.length) {
                    this.error = false;
                    return true;
                }
                this.error = true;
                return false;
            }
        }
    }
</script>
