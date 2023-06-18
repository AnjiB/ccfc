docker run --rm -v /${PWD}:/${PWD} -w ${PWD} \
      -e PACT_BROKER_BASE_URL \
      -e PACT_BROKER_TOKEN \
      pactfoundation/pact-cli:latest \
      pact-broker record_deployment --pacticipant fraud-service-provider --version 1.0.0 --environment production