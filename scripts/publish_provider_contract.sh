docker run --rm -v /${PWD}:/${PWD} -w ${PWD} \
      -e PACT_BROKER_BASE_URL \
      -e PACT_BROKER_TOKEN \
      pactfoundation/pact-cli:latest \
      pactflow publish-provider-contract docs/oas_contract/ccfc_provider_contract.json \
      --provider fraud-service-provider \
      --provider-app-version  1.0.0\
      --branch main \
      --content-type application/json \
      --verification-exit-code=0 \
      --verification-results target/surefire-reports/TEST-com.anji.finance.ccfc.CcfcProviderVerificationTest.xml \
      --verification-results-content-type text/xml \
      --verifier restassured