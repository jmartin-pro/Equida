<#include "/layouts/simple.ftl"/>

<#global theme="contextual">
<#global css="home">
<#global title="">

<#macro content>
</#macro>

<#macro extra>

    <form class="search-apporteur search-apporteur--modal overlay is-visible" action="/" method="post" autocomplete="off">

        <dialog class="mdl-dialog mdl-dialog--centered" open="">
            <h4 class="mdl-dialog__title">Bonjour</h4>
            <div class="mdl-dialog__content">
                <p>Choisissez un client pour commencer</p>
                <div class="mdl-textfield mdl-js-textfield apporteur-autocomplete">
                    <input class="mdl-textfield__input" type="search" autofocus="autofocus" />
                    <label class="mdl-textfield__label">Nom ou n° d'apporteur...</label>
                </div>
                <input type="hidden" name="q" />
            </div>

            <div class="mdl-dialog__actions">
                <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-button--primary">Rechercher</button>
            </div>

            <div class="separator separator--or">
                <hr/>
                <a class="mdl-button mdl-js-button" href="/tiers/">Créer un nouveau client</a>
            </div>

        </dialog>

    </form>

</#macro>

<@render_html/>