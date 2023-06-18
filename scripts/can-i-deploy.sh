docker run --rm -v /${PWD}:/${PWD} -w ${PWD} \
      -e PACT_BROKER_BASE_URL \
      -e PACT_BROKER_TOKEN \
      pactfoundation/pact-cli:latest \
      pact-broker can-i-deploy \
	  --pacticipant fraud-service-provider \
	  --version 1.0.0 \
	  --to-environment production \
	  --retry-while-unknown 6 \
	  --retry-interval 10 