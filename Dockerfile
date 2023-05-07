FROM tinkerpop/gremlin-console:latest

WORKDIR /opt/gremlin-console/

COPY ./conf/remote-secure.yaml conf/remote-secure.yaml

VOLUME ./scripts /opt/gremlin-console/scripts
